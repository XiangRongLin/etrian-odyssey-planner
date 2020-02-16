<template>
    <div>
        <input v-bind="searchValue">
        <button v-on:click="searchCharacter">search</button>
        <datalist id="suggestions" v-for="suggestion in suggestions" v-bind:key="suggestion.id">
            <option>{{suggestion.name}}</option>
        </datalist>
        <p>party id {{id}}</p>
        <h3>{{name}}</h3>
        <PartyMemberList :party-id=id></PartyMemberList>
    </div>
</template>

<script>
    import {CharacterService, PartyService} from "@/api";
    import CharacterList from "@/components/CharacterList";
    import PartyMemberList from "@/components/PartyMemberList";

    export default {
        name: "Party",
        components: {PartyMemberList, CharacterList},
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
        methods: {
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