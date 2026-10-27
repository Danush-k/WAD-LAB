<script setup>
import { ref } from 'vue'

const API = 'http://localhost:8080/api/reason'

const leaveReason = ref('')
const employees = ref([])
const hasSearched = ref(false)
const isSearching = ref(false)

async function searchEmployees() {
  if (!leaveReason.value.trim()) {
    alert('Please enter a leave reason to search!')
    return
  }

  isSearching.value = true
  hasSearched.value = true

  try {
    const res = await fetch(`${API}/${encodeURIComponent(leaveReason.value.trim())}`)
    const data = await res.json()

    if (data.msg) {
      employees.value = []
      alert(data.msg)
    } else if (Array.isArray(data)) {
      employees.value = data
      if (data.length === 0) {
        alert('No employees found for this reason.')
      }
    }
  } catch (error) {
    employees.value = []
    alert('Error connecting to backend: ' + error.message)
  } finally {
    isSearching.value = false
  }
}
</script>

<template>
  <div class="panel">
    <h2>Search Leave by Reason</h2>

    <!-- Search Input Row -->
    <div class="search-row">
      <input
        v-model="leaveReason"
        type="text"
        placeholder="Enter leave reason (e.g. Medical)"
        @keyup.enter="searchEmployees"
      />
      <button class="btn-search" @click="searchEmployees" :disabled="isSearching">
        {{ isSearching ? 'Searching...' : 'Search' }}
      </button>
    </div>

    <!-- Table of Results -->
    <table v-if="employees.length > 0" class="results-table">
      <thead>
        <tr>
          <th>Emp ID</th>
          <th>Name</th>
          <th>Details</th>
          <th>Available Leaves</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="emp in employees" :key="emp.employeeId">
          <td>{{ emp.employeeId }}</td>
          <td>{{ emp.employeeName }}</td>
          <td>{{ emp.employeeDetails || 'N/A' }}</td>
          <td>{{ emp.availableLeave }}</td>
        </tr>
      </tbody>
    </table>

    <p v-else-if="hasSearched && !isSearching" class="no-data">
      No employees found for this reason.
    </p>
  </div>
</template>

<style scoped>
.panel {
  background-color: #ffffff;
  border: 1px solid #cccccc;
  border-radius: 4px;
  padding: 20px;
}

h2 {
  font-size: 17px;
  margin-bottom: 16px;
  padding-bottom: 8px;
  border-bottom: 1px solid #eeeeee;
  color: #222222;
}

.search-row {
  display: flex;
  gap: 8px;
  margin-bottom: 14px;
}

input {
  flex: 1;
  padding: 8px 10px;
  border: 1px solid #cccccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input:focus {
  border-color: #0066cc;
  outline: none;
}

.btn-search {
  background-color: #0066cc;
  color: #ffffff;
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: bold;
  white-space: nowrap;
}

.btn-search:hover:not(:disabled) {
  background-color: #0052a3;
}

.btn-search:disabled {
  background-color: #999999;
  cursor: not-allowed;
}

.results-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 10px;
}

.results-table th,
.results-table td {
  border: 1px solid #dddddd;
  padding: 8px 10px;
  text-align: left;
  font-size: 13.5px;
}

.results-table th {
  background-color: #f2f2f2;
  font-weight: bold;
  color: #333333;
}

.results-table tr:nth-child(even) {
  background-color: #fafafa;
}

.no-data {
  padding: 12px;
  background-color: #f9f9f9;
  border: 1px solid #e0e0e0;
  border-radius: 4px;
  font-size: 13px;
  color: #666666;
  text-align: center;
}
</style>
