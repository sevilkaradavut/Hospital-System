import Vue from 'vue'
import Router from 'vue-router'
import DoctorCrud from '@/components/DoctorCrud'
import PatientCrud from '@/components/PatientCrud'
import AppointmentCrud from '@/components/AppointmentCrud'
import ExaminationCrud from '@/components/ExaminationCrud'
import MedicineCrud from '@/components/MedicineCrud'

import Home from '@/components/Home'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/doctor',
      name: 'DoctorCrud',
      component: DoctorCrud
    },
    {
      path: '/patient',
      name: 'PatientCrud',
      component: PatientCrud
    },
    {
      path: '/appointment',
      name: 'AppointmentCrud',
      component: AppointmentCrud
    },
    {
      path: '/examination',
      name: 'ExaminationCrud',
      component: ExaminationCrud
    },
    {
      path: '/medicine',
      name: 'MedicineCrud',
      component: MedicineCrud
    }
  ]
})
