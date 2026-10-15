<script setup>
import { ref } from 'vue';

const API='http://localhost:8080/api/students'

const studentId=ref('')
const studentName=ref('')

async function updateStudent() {
    const student={
        studentName:studentName.value
    }

    const res=await fetch(API+'/'+studentId.value+'/name',{
        method:'PUT',
        headers:{
            'Content-Type':'application/json'
        },
        body:JSON.stringify(student)
    })

    const data= await res.text()
      alert('Backend response: ' + data)

}
</script>

<template>
  <h2>Update Student</h2>

  <input v-model="studentId" placeholder="Student ID">
  <br><br>

  <input v-model="studentName" placeholder="New Name">
  <br><br>

  <button @click="updateStudent">
    Update Student
  </button>
</template>