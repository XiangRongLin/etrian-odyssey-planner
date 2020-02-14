<template>
    <div>
        <div>
            <h3>New Character</h3>
            <span>name   </span><input v-model="newName">
            <button v-on:click="submitNewCharacter">Submit</button>
        </div>
        <br>
        <h3>Character List</h3>
        <div>
            <ul v-for="result in results" v-bind:key="result.id">
                <CharacterPreview :id=result.id :name="result.name"></CharacterPreview>
            </ul>
        </div>
    </div>
</template>

<script>
    import {CharacterService} from "@/api";
    import CharacterPreview from "@/components/CharacterPreview";

    export default {
        name: "CharacterList",
        components: {CharacterPreview},
        data() {
            return {
                results: [],
                newName: ''
            }
        },
        mounted() {
            this.getCharacters()
        },
        methods: {
            async getCharacters() {
                CharacterService.get().then(response =>
                    this.results = response.data)
            },
            async submitNewCharacter() {
                CharacterService.create({
                    name: this.newName
                }).then(() => this.getCharacters())
            }
        }
    }
</script>

<style scoped>

</style>