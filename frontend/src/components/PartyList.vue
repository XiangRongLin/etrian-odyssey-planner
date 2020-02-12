<template>
    <div>
        <div>
            <h3>New Party</h3>
            <span>name   </span><input v-model="newName">
            <button v-on:click="submitNewParty">Submit</button>
        </div>
        <br>
        <h3>Party List</h3>
        <div>
            <ul v-for="result in results" v-bind:key="result.id">
                <router-link :id="result.id" :to="{name : 'party'}">{{result.name}}</router-link>
            </ul>
        </div>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "Party",
        data() {
            return {
                results: [],
                newName: ''
            }
        },
        mounted() {
            this.getParties()
        },
        methods: {
            async getParties() {
                axios.get('http://localhost:8080/api/party')
                    .then(response => (this.results = response.data))
            },
            async submitNewParty() {
                axios.post('http://localhost:8080/api/party',
                    {
                        name: this.newName
                    },
                    {
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(() => this.getParties())
            }
        }
    }
</script>

<style scoped>

</style>