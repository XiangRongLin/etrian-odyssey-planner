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
                <PartyPreview :id=result.id :name="result.name"></PartyPreview>
            </ul>
        </div>
    </div>
</template>

<script>
    import PartyPreview from "@/components/PartyPreview";
    import {PartyService} from "@/api";

    export default {
        name: "Party",
        components: {PartyPreview},
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
                PartyService.get().then(response => (this.results = response.data))
            },
            async submitNewParty() {
                PartyService.create({
                    name: this.newName
                }).then(() => this.getParties());
            }
        },

    }
</script>

<style scoped>

</style>