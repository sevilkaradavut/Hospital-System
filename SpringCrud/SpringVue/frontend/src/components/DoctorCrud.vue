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
        <h2>Doctor</h2>
        <form @submit.prevent="save">
            <div class="form-group">
                <label>Doctor Name</label>
                <input type="text" v-model="doctor.doctorname" class="form-control" placeholder="Doctor name">

            </div>
            <div class="form-group">
                <label>Doctor Branch</label>
                <input type="text" v-model="doctor.doctorbranch" class="form-control" placeholder="Doctor Branch">

            </div>
            <div class="form-group">
                <label>Phone</label>
                <input type="text" v-model="doctor.phone" class="form-control" placeholder="Phone">

            </div>
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
        <h2>Doctor View</h2>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Doctor Name</th>
                    <th scope="col">Doctor Branch</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Option</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="doctor in result" v-bind:key="doctor.doctorid">

                    <td>{{ doctor.doctorid }}</td>
                    <td>{{ doctor.doctorname }}</td>
                    <td>{{ doctor.doctorbranch }}</td>
                    <td>{{ doctor.phone }}</td>
                    <td>
                        <button type="button" class="btn btn-warning" @click="edit(doctor)">Edit</button>
                        <button type="button" class="btn btn-danger" @click="remove(doctor)">Delete</button>
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
    name: 'DoctorCrud',
    data() {
        return {
            result: {},

            doctor: {
                doctorid: '',
                doctorname: '',
                doctorbranch: '',
                phone: ''
            }
        }
    },
    created() {
        this.DoctoreLoad();
    },
    mounted() {
        console.log("mounted() called.......");

    },
    methods: {
        DoctoreLoad() {
            var page = "http://localhost:8084/api/v1/doctor/getAllDoctor";
            axios.get(page)
                .then(
                    ({ data }) => {
                        console.log(data);
                        this.result = data;
                    }
                );
        },


        save() {
            if (this.doctor.doctorid == '') {
                this.saveData();
            }
            else {
                this.updateData();
            }
        },
        saveData() {
            axios.post("http://localhost:8084/api/v1/doctor/save", this.doctor)
                .then(
                    ({ data }) => {
                        alert("Saved");
                        this.doctor.doctorid = '';
                        this.doctor.doctorname = '';
                        this.doctor.doctorbranch = '';
                        this.doctor.phone = '';
                        this.DoctoreLoad();
                    }
                )
        },
        edit(doctor) {
            this.doctor = doctor;

        },
        updateData() {
            var editrecords = 'http://localhost:8084/api/v1/doctor/update/';
            axios.put(editrecords, this.doctor)
                .then(
                    ({ data }) => {
                        this.doctor.doctorid = '';
                        this.doctor.doctorname = '';
                        this.doctor.doctorbranch = '';
                        this.doctor.phone = '';
                        this.doctorid = '';
                        alert("Updated");
                        this.DoctoreLoad();
                    }
                );
        },
        remove(doctor) {
            var url = `http://localhost:8084/api/v1/doctor/deletedoctor/${doctor.doctorid}`;
            axios.delete(url);
            alert("Deleted");
            this.DoctoreLoad();
        }
    }
}
</script>