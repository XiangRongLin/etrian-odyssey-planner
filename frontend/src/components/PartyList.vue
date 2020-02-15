<template>
    <div>
        <md-list v-for="result in results" v-bind:key="result.id">
            <PartyPreview :id=result.id :name="result.name"></PartyPreview>
        </md-list>
    </div>
</template>

<script>
    import PartyAdd from "@/components/PartyAdd";
    import PartyPreview from "@/components/PartyPreview";
    import {PartyService} from "@/api";

    export default {
        name: "Party",
        components: {PartyAdd, PartyPreview},
        props: {
            newParty: Object
        },
        watch: {
            newParty(newValue) {
                this.results.push(newValue);
            }
        },
        data() {
            return {
                results: [],
            }
        },
        mounted() {
            this.getParties()
        },
        methods: {
            async getParties() {
                PartyService.get().then(response =>
                    this.results = response.data)
            }
        },

    }
</script>

<style scoped>
</style>