<template>
    <div>
        <input v-bind="searchValue">
        <button v-on:click="searchCharacter">search</button>
        <datalist id="suggestions" v-for="suggestion in suggestions" v-bind:key="suggestion.id">
            <option>{{suggestion.name}}</option>
        </datalist>
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
    import {CharacterService, PartyService} from "@/api";

    export default {
        name: "Party",
        props: {
            id: Number,
            name: String
        },
        data() {
            return {
                members: [],
                searchValue: String,
                suggestions: []
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
            },
            async searchCharacter() {
                CharacterService.search(this.searchValue)
                    .then(response =>  {
                        this.suggestions = response.data
                    })
            }
        }
    }
</script>

<style scoped>
    .autocomplete {
        /*the container must be positioned relative:*/
        position: relative;
        display: inline-block;
    }
</style>