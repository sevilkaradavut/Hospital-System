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
        <h2>Examination</h2>
        <form @submit.prevent="save">
            <div class="form-group">
                <label>Examination description</label>
                <input type="text" v-model="examination.examinationdescription" class="form-control" placeholder="Examination description">

            </div>

            <div class="form-group">
                <label>Patient</label>
                <select v-model="examination.patient" class="form-control">
                    <option v-for="patient in result2" :key="patient.patientid" :value="patient.patientid">
                        {{ patient.patientname }}
                    </option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form>
        <h2>Examination View</h2>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Examination Description</th>
                    <th scope="col">Patient</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="examination in result" v-bind:key="examination.examinationid">

                    <td>{{ examination.examinationid }}</td>
                    <td>{{ examination.examinationdescription }}</td>
                    <td>{{ examination.patient }}</td>
                    <td>
                        <button type="button" class="btn btn-warning" @click="edit(examination)">Edit</button>
                        <button type="button" class="btn btn-danger" @click="remove(examination)">Delete</button>
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
    name: 'ExaminationCrud',
    data() {
        return {
            result: {},
            result2: {},
            examination: {
                examinationid: '',
                examinationdescription: '',
                patient: ''
            }
        }
    },
    created() {
        this.ExaminationeLoad();
        this.PatienteLoad();
    },
    mounted() {
        console.log("mounted() called.......");

    },
    methods: {
        ExaminationeLoad() {
            var page = "http://localhost:8084/api/v1/examination/getAllExamination";
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
            if (this.examination.examinationid == '') {
                this.saveData();
            }
            else {
                this.updateData();
            }
        },
        saveData() {
            axios.post("http://localhost:8084/api/v1/examination/save", this.examination)
                .then(
                    ({ data }) => {
                        alert("Saved");
                        this.examination.examinationid = '';
                        this.examination.examinationdescription = '';
                        this.examination.patient = '';
                        this.ExaminationeLoad();
                    }
                )
        },
        edit(examination) {
            this.examination = examination;

        },
        updateData() {
            var editrecords = 'http://localhost:8084/api/v1/examination/update/';
            axios.put(editrecords, this.examination)
                .then(
                    ({ data }) => {
                        this.examination.examinationid = '';
                        this.examination.examinationdescription = '';
                        this.examination.patient = '';
                        this.examination = '';
                        alert("Updated!");
                        this.ExaminationeLoad();
                    }
                );
        },
        remove(examination) {
            var url = `http://localhost:8084/api/v1/examination/deleteexamination/${examination.examinationid}`;
            axios.delete(url);
            alert("Deleted");
            this.ExaminationeLoad();
        }
    }
}
</script>