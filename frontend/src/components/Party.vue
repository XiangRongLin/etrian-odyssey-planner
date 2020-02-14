<template>
    <div>
        <p>{{id}}</p>
        <h3>{{name}}</h3>
        <ul v-for="character in members" v-bind:key="character.id">
            <div>
                <p>Name: {{character.member.name}} || Position: {{character.position}}</p>
            </div>
        </ul>
    </div>
</template>

<script>
    import {PartyService} from "@/api";

    export default {
        name: "Party",
        props: {
            id: Number,
            name: String
        },
        data() {
            return {
                members: []
            }
        },
        mounted() {
            this.getMembers()
        },
        methods: {
            async getMembers() {
                PartyService.getMembers(this.id)
                    .then(response => {
                        this.members = response.data
                    });
            }
        }
    }
</script>

<style scoped>

</style>