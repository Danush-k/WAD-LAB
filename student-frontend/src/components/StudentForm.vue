<script setup>
import {ref} from 'vue'

const API='http://localhost:8080/api/students'

const studentId=ref('')
const studentName = ref('')
const department = ref('')
const email = ref('')

async function addStudent()
{
    const student={
        studentId: studentId.value,
        studentName: studentName.value,
        department: department.value,
        email: email.value
    }

    await fetch(API,{
        method:'post',
        headers:
        {
            'Content-Type':'application/json'
        },
        body:JSON.stringify(student)
    })

    alert('student added successfully')
}
</script>

<template>
    <h2>Add Student</h2>

    <input v-model="studentId" placeholder="StudentId">
    <input v-model="studentName" placeholder="Student Name">
    <input v-model="department" placeholder="Department">
    <input v-model="email" placeholder="Email">

    <button @click="addStudent">add Student</button>
</template>