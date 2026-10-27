<script setup>
import ApplyLeave from './components/ApplyLeave.vue'
import SearchLeave from './components/SearchLeave.vue'
</script>

<template>
  <div class="container">
    <h1 class="page-title">Leave Management System</h1>

    <!-- Both forms displayed directly -->
    <main class="content-grid">
      <ApplyLeave />
      <SearchLeave />
    </main>
  </div>
</template>

<style scoped>
.container {
  max-width: 1000px;
  margin: 0 auto;
}

.page-title {
  font-size: 22px;
  color: #222222;
  margin-bottom: 20px;
  text-align: center;
  font-weight: bold;
}

.content-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 20px;
  align-items: start;
}

@media (max-width: 768px) {
  .content-grid {
    grid-template-columns: 1fr;
  }
}
</style>
