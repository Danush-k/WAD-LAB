<script setup>
import {ref,onMounted} from 'vue'

const API='http://localhost:8080/api/students'

const students=ref([])

async function getStudents() {
    const response=await fetch(API)

    students.value=await response.json()
    
}
async function deleteStudent(id) {
    await fetch(API+'/'+id,{
        method:'DELETE'
    })

    getStudents()
    
}
onMounted(getStudents)
</script>

<template>
    <h2>Studnet List</h2>
    
    <div v-for="s in students" :key="s.studentId">
        {{ s.studentId }}
        {{ s.studentName }}
        {{ s.department }}
        {{ s.email }}
        <button @click="deleteStudent(s.studentId)">Delete</button>
        <hr>
    </div>
</template>