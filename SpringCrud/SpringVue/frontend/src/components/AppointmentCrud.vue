<template>
    <div>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">HOSPITAL SYSTEM</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Home <span class="sr-only"></span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#/doctor">Doctor</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#/patient">Patient</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#/appointment">Appointment</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#/examination">Examination</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#/medicine">Medicine</a>
                    </li>
                </ul>
            </div>
        </nav>
        <h2>Appointment</h2>
        <form @submit.prevent="save">
            <div class="form-group">
                <label>Appointment description</label>
                <input type="text" v-model="appointment.appointmentdescription" class="form-control" placeholder="Appointment description">

            </div>
            <div class="form-group">
                <label>Appointment Date</label>
                <input type="date" v-model="appointment.appointmentdate" class="form-control" placeholder="Appointment Date">

            </div>

            <div class="form-group">
                <label>Patient</label>
                <select v-model="appointment.patient" class="form-control">
                    <option v-for="patient in result2" :key="patient.patientid" :value="patient.patientid">
                        {{ patient.patientname }}
                    </option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
        <h2>Appointment View</h2>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Appointment Description</th>
                    <th scope="col">Appointment Date</th>
                    <th scope="col">Patient</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="appointment in result" v-bind:key="appointment.appointmentid">

                    <td>{{ appointment.appointmentid }}</td>
                    <td>{{ appointment.appointmentdescription }}</td>
                    <td>{{ appointment.appointmentdate }}</td>
                    <td>{{ appointment.patient }}</td>
                    <td>
                        <button type="button" class="btn btn-warning" @click="edit(appointment)">Edit</button>
                        <button type="button" class="btn btn-danger" @click="remove(appointment)">Delete</button>
                    </td>
                </tr>

            </tbody>
        </table>

    </div>
</template>
  
<script>
import Vue from 'vue';
import axios from 'axios';
Vue.use(axios)
export default {
    name: 'AppointmentCrud',
    data() {
        return {
            result: {},
            result2: {},
            appointment: {
                appointmentid: '',
                appointmentdescription: '',
                appointmentdate: '',
                patient: ''
            }
        }
    },
    created() {
        this.AppointmenteLoad();
        this.PatienteLoad();
    },
    mounted() {
        console.log("mounted() called.......");

    },
    methods: {
        AppointmenteLoad() {
            var page = "http://localhost:8084/api/v1/appointment/getAllAppointment";
            axios.get(page)
                .then(
                    ({ data }) => {
                        this.result = data;
                    }
                );
        },
        PatienteLoad() {
            var page2 = "http://localhost:8084/api/v1/patient/getAllPatient";
            axios.get(page2)
                .then(
                    ({ data }) => {
                        this.result2 = data;
                    }
                );
        },
        save() {
            if (this.appointment.appointmentid == '') {
                this.saveData();
            }
            else {
                this.updateData();
            }
        },
        saveData() {
            axios.post("http://localhost:8084/api/v1/appointment/save", this.appointment)
                .then(
                    ({ data }) => {
                        alert("Saved");
                        this.appointment.appointmentid = '';
                        this.appointment.appointmentdescription = '';
                        this.appointment.appointmentdate = '';
                        this.appointment.patient = '';
                        this.AppointmenteLoad();
                    }
                )
        },
        edit(appointment) {
            this.appointment = appointment;

        },
        updateData() {
            var editrecords = 'http://localhost:8084/api/v1/appointment/update/';
            axios.put(editrecords, this.appointment)
                .then(
                    ({ data }) => {
                        this.appointment.appointmentid = '';
                        this.appointment.appointmentdescription = '';
                        this.appointment.appointmentdate = '';
                        this.appointment.patient = '';
                        this.appointment = '';
                        alert("Updated!");
                        this.AppointmenteLoad();
                    }
                );
        },
        remove(appointment) {
            var url = `http://localhost:8084/api/v1/appointment/deleteappointment/${appointment.appointmentid}`;
            axios.delete(url);
            alert("Deleted");
            this.AppointmenteLoad();
        }
    }
}
</script>