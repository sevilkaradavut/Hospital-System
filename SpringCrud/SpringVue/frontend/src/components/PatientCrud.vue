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
        <h2>Patient Registation</h2>
        <form @submit.prevent="save">
            <div class="form-group">
                <label>Patient name</label>
                <input type="text" v-model="patient.patientname" class="form-control" placeholder="Patient name">

            </div>
            <div class="form-group">
                <label>Patient Address</label>
                <input type="text" v-model="patient.patientaddress" class="form-control" placeholder="Patient Address">

            </div>
            <div class="form-group">
                <label>Phone</label>
                <input type="text" v-model="patient.phone" class="form-control" placeholder="Phone">

            </div>
            <div class="form-group">
                <label>Doctor</label>
                <select v-model="patient.doctor" class="form-control">
                    <option v-for="doctor in result2" :key="doctor.doctorid" :value="doctor.doctorid">
                        {{ doctor.doctorname }}
                    </option>
                </select>
         


            </div>
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
        <h2>Patient View</h2>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Patient Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Doctor</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="patient in result" v-bind:key="patient.patientid">

                    <td>{{ patient.patientid }}</td>
                    <td>{{ patient.patientname }}</td>
                    <td>{{ patient.patientaddress }}</td>
                    <td>{{ patient.phone }}</td>
                    <td>{{ patient.doctor }}</td>
                    <td>
                        <button type="button" class="btn btn-warning" @click="edit(patient)">Edit</button>
                        <button type="button" class="btn btn-danger" @click="remove(patient)">Delete</button>
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
    name: 'PatientCrud',
    data() {
        return {
            result: {},
            result2: {},
            patient: {
                patientid: '',
                patientname: '',
                patientaddress: '',
                phone: '',
                doctor: '',
            }
        }
    },
    created() {
        this.PatienteLoad();
        this.DoctoreLoad();
    },
    mounted() {
   

    },
    methods: {
        PatienteLoad() {
            var page = "http://localhost:8084/api/v1/patient/getAllPatient";
            axios.get(page)
                .then(
                    ({ data }) => {
                        this.result = data;
                    }
                );
        },
        DoctoreLoad() {
            var page2 = "http://localhost:8084/api/v1/doctor/getAllDoctor";
            axios.get(page2)
                .then(
                    ({ data }) => {
                        this.result2 = data;
                    }
                );
        },
        save() {
            if (this.patient.patientid == '') {
                this.saveData();
            }
            else {
                this.updateData();
            }
        },
        saveData() {
            axios.post("http://localhost:8084/api/v1/patient/save", this.patient)
                .then(
                    ({ data }) => {
                        alert("Saved");
                        this.patient.patientid = '';
                        this.patient.patientname = '';
                        this.patient.patientaddress = '';
                        this.patient.phone = '';
                        this.patient.doctor = '';
                        this.PatienteLoad();
                    }
                )
        },
        edit(patient) {
            this.patient = patient;

        },
        updateData() {
            var editrecords = 'http://localhost:8084/api/v1/patient/update/';
            axios.put(editrecords, this.patient)
                .then(
                    ({ data }) => {
                        this.patient.patientid = '';
                        this.patient.patientname = '';
                        this.patient.patientaddress = '';
                        this.patient.phone = '';
                        this.patient.doctor = '';
                        alert("Updated!");
                        this.PatienteLoad();
                    }
                );
        },
        remove(patient) {
            var url = `http://localhost:8084/api/v1/patient/deletepatient/${patient.patientid}`;
            axios.delete(url);
            alert("Deleted");
            this.PatienteLoad();
        }
    }
}
</script>
