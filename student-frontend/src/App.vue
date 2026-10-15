<script setup>
import { RouterLink, RouterView } from 'vue-router'

</script>

<template>
  
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/add">addStudnet</RouterLink>
        <RouterLink to="/update">updateStudnets</RouterLink>
      </nav>
      <hr>
    


  <RouterView />
</template>

