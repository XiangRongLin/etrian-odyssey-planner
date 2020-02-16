<template>
    <div>
        <md-toolbar :md-elevation="1">
            <span class="md-title">Character list</span>
        </md-toolbar>
        <md-list v-for="result in results" v-bind:key="result.id">
            <CharacterPreview :id=result.id :name="result.name"></CharacterPreview>
        </md-list>
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