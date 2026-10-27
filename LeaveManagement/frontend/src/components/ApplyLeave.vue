<script setup>
import { ref } from 'vue'

const API = 'http://localhost:8080/api/apply'

const employeeId = ref('')
const startDate = ref('')
const endDate = ref('')
const days = ref('')
const leaveReason = ref('')
const responseMsg = ref('')
const isSuccess = ref(false)
const isSubmitting = ref(false)

async function applyLeave() {
  if (!employeeId.value || !days.value || !leaveReason.value) {
    alert('Please provide Employee ID, Days, and Reason!')
    return
  }

  const leave = {
    employeeId: employeeId.value.trim(),
    startDate: startDate.value,
    endDate: endDate.value,
    days: Number(days.value),
    leaveReason: leaveReason.value.trim(),
    appliedDate: new Date().toISOString().split('T')[0]
  }

  isSubmitting.value = true

  try {
    const res = await fetch(API, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(leave)
    })

    const text = await res.text()
    try {
      const data = JSON.parse(text)
      responseMsg.value = data.message || data.msg || text
    } catch {
      responseMsg.value = text
    }

    if (responseMsg.value.toLowerCase().includes('approved')) {
      isSuccess.value = true
      alert('Leave Application: ' + responseMsg.value)
      employeeId.value = ''
      startDate.value = ''
      endDate.value = ''
      days.value = ''
      leaveReason.value = ''
    } else {
      isSuccess.value = false
      alert('Response: ' + responseMsg.value)
    }
  } catch (error) {
    responseMsg.value = 'Backend connection error: ' + error.message
    isSuccess.value = false
    alert('Backend connection error: ' + error.message)
  } finally {
    isSubmitting.value = false
  }
}
</script>

<template>
  <div class="panel">
    <h2>Apply for Leave</h2>

    <form @submit.prevent="applyLeave">
      <div class="form-group">
        <label for="empId">Employee ID:</label>
        <input
          id="empId"
          v-model="employeeId"
          placeholder="Enter Employee ID"
          required
        />
      </div>

      <div class="form-row">
        <div class="form-group">
          <label for="startDate">Start Date:</label>
          <input
            id="startDate"
            type="date"
            v-model="startDate"
          />
        </div>
        <div class="form-group">
          <label for="endDate">End Date:</label>
          <input
            id="endDate"
            type="date"
            v-model="endDate"
          />
        </div>
      </div>

      <div class="form-group">
        <label for="days">Number of Days:</label>
        <input
          id="days"
          type="number"
          min="1"
          v-model="days"
          placeholder="Enter number of days"
          required
        />
      </div>

      <div class="form-group">
        <label for="reason">Leave Reason:</label>
        <input
          id="reason"
          v-model="leaveReason"
          placeholder="Enter reason (e.g. Medical, Vacation)"
          required
        />
      </div>

      <button type="submit" class="btn-submit" :disabled="isSubmitting">
        {{ isSubmitting ? 'Submitting...' : 'Apply Leave' }}
      </button>

      <div v-if="responseMsg" :class="['message', isSuccess ? 'success' : 'error']">
        {{ responseMsg }}
      </div>
    </form>
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

.form-group {
  margin-bottom: 14px;
}

label {
  display: block;
  font-size: 13px;
  font-weight: bold;
  margin-bottom: 5px;
  color: #333333;
}

input {
  width: 100%;
  padding: 8px 10px;
  border: 1px solid #cccccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input:focus {
  border-color: #0066cc;
  outline: none;
}

.form-row {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 10px;
}

@media (max-width: 480px) {
  .form-row {
    grid-template-columns: 1fr;
  }
}

.btn-submit {
  width: 100%;
  background-color: #0066cc;
  color: #ffffff;
  padding: 9px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: bold;
  margin-top: 4px;
}

.btn-submit:hover:not(:disabled) {
  background-color: #0052a3;
}

.btn-submit:disabled {
  background-color: #999999;
  cursor: not-allowed;
}

.message {
  margin-top: 12px;
  padding: 8px 12px;
  border-radius: 4px;
  font-size: 13px;
}

.message.success {
  background-color: #e6f4ea;
  color: #137333;
  border: 1px solid #ceead6;
}

.message.error {
  background-color: #fce8e6;
  color: #c5221f;
  border: 1px solid #fad2cf;
}
</style>
