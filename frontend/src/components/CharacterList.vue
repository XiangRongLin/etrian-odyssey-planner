<template>
    <div>
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
        props: {
            newCharacter: Object
        },
        watch: {
            newCharacter(newValue) {
                this.results.push(newValue);
            }
        },
        data() {
            return {
                results: [],
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

        }
    }
</script>

<style scoped>

</style>