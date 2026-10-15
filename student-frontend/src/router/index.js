import { createRouter, createWebHistory } from 'vue-router'
import StudentForm from '@/components/StudentForm.vue'
import StudentList from '@/components/StudentList.vue'
import UpdateStudents from '@/components/UpdateStudents.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: StudentList,
    },
    {
      path:'/add',
      component: StudentForm,
    },
    {
      path:'/update',
      component: UpdateStudents,
    }
  ],
})  

export default router
