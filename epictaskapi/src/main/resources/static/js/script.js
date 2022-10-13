let labelscore = document.querySelector("#labelscore")
let score = document.querySelector("#score")

score.addEventListener("input", (e) => {
    labelscore.innerHTML = e.target.value + "pts"
})