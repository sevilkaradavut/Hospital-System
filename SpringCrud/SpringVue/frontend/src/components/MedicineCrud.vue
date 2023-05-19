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
        <h2>Medicine</h2>
        <form @submit.prevent="save">
            <div class="form-group">
                <label>Medicine description</label>
                <input type="text" v-model="medicine.medicinedescription" class="form-control"
                    placeholder="Medicine description">

            </div>

            <div class="form-group">
                <label>Examination</label>
                <select v-model="medicine.examination" class="form-control">
                    <option v-for="examination in result2" :key="examination.examinationid"
                        :value="examination.examinationid">
                        {{ examination.examinationdescription }}
                    </option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form>
        <h2>Medicine View</h2>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Medicine Description</th>
                    <th scope="col">Examination</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="medicine in result" v-bind:key="medicine.medicineid">

                    <td>{{ medicine.medicineid }}</td>
                    <td>{{ medicine.medicinedescription }}</td>
                    <td>{{ medicine.examination }}</td>
                    <td>
                        <button type="button" class="btn btn-warning" @click="edit(medicine)">Edit</button>
                        <button type="button" class="btn btn-danger" @click="remove(medicine)">Delete</button>
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
    name: 'MedicineCrud',
    data() {
        return {
            result: {},
            result2: {},
            medicine: {
                medicineid: '',
                medicinedescription: '',
                examination: ''
            }
        }
    },
    created() {
        this.MedicineeLoad();
        this.ExaminationeLoad();
    },
    mounted() {
        console.log("mounted() called.......");

    },
    methods: {
        MedicineeLoad() {
            var page = "http://localhost:8084/api/v1/medicine/getAllMedicine";
            axios.get(page)
                .then(
                    ({ data }) => {
                        this.result = data;
                    }
                );
        },
        ExaminationeLoad() {
            var page2 = "http://localhost:8084/api/v1/examination/getAllExamination";
            axios.get(page2)
                .then(
                    ({ data }) => {
                        this.result2 = data;
                    }
                );
        },

        save() {
            if (this.medicine.medicineid == '') {
                this.saveData();
            }
            else {
                this.updateData();
            }
        },
        saveData() {
            axios.post("http://localhost:8084/api/v1/medicine/save", this.medicine)
                .then(
                    ({ data }) => {
                        alert("Saved");
                        this.medicine.medicineid = '';
                        this.medicine.medicinedescription = '';
                        this.medicine.examination = '';
                        this.MedicineeLoad();
                    }
                )
        },
        edit(medicine) {
            this.medicine = medicine;

        },
        updateData() {
            var editrecords = 'http://localhost:8084/api/v1/medicine/update/';
            axios.put(editrecords, this.medicine)
                .then(
                    ({ data }) => {
                        this.medicine.medicineid = '';
                        this.medicine.medicinedescription = '';
                        this.medicine.examination = '';
                        this.medicine = '';
                        alert("Updated!");
                        this.MedicineeLoad();
                    }
                );
        },
        remove(medicine) {
            var url = `http://localhost:8084/api/v1/medicine/deletemedicine/${medicine.medicineid}`;
            axios.delete(url);
            alert("Deleted");
            this.MedicineeLoad();
        }
    }
}
</script>