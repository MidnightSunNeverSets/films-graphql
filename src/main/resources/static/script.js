fetch('/graphql', {
    method: 'POST',

    headers: {
        "Content-Type": "application/json"
    },

    body: JSON.stringify({
        query: 'query FilmsQuery { films { edges { node { title projectName } } } }'
    })
})
.then(response => response.json())
.then(res => { // returns the entire graphql object
    const data = res.data; // get the data part
    const films = document.getElementById("films"); // get the films div

    data.films.edges.forEach(element => {
        const title = element.node.title;
        const projectName = element.node.projectName;

        // add to html
        var film = addFilmLink(title, projectName);
        films.appendChild(film);
        films.appendChild(document.createElement('br'));

        // set event listener on film link
        film.addEventListener("click", function() {
            getClickedFilm(projectName, title);
        });
    });
});

function getClickedFilm(projectName, title) {
    var film_title = document.getElementById("film_title");
    film_title.innerText = title;

    var project_tag = document.getElementById("project_title");
    project_tag.innerText = projectName;

    fetch('/graphql', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            query: 'query FilmQuery($project_name: String!) { film(projectName: $project_name) { characters { name, playedBy { username, firstName, lastName } }, scenes { id, shots { id } } } }',
            variables: {"project_name": projectName}
        })
    })
    .then(response => response.json())
    .then(res => {
        addScenes(res.data.film.scenes);
        addActors(res.data.film.characters)
    })
}

function addFilmLink(title, projectName) {
    let film = document.createElement('div');
    film.innerText = title;
    film.setAttribute("id", projectName);
    film.setAttribute("class", "clickable");
    return film;
}

function addActors(characters) {
    var charactersByActor = new Map();
    let actors = "";

    characters.forEach(character => {
        const actorUsername = character.playedBy.username;
        const actorName = character.playedBy.firstName + " " + character.playedBy.lastName;
        const characterName = character.name;

        console.log(actorName);

        if (!charactersByActor.has(actorUsername)) {
            charactersByActor.set(actorUsername, actorName + " as " + characterName);
        } else {
            charactersByActor.set(actorUsername, charactersByActor.get(actorUsername) + ", " + characterName);
        }
    });

    for (const value of charactersByActor.values()) {
        actors += value + "<br>";
    }

    var actors_tag = document.getElementById("actors");
    actors_tag.innerHTML = actors;
}

function addScenes(scenes) {
    let scenesText = ""; // stores paragraph text for Scenes heading on webpage
    let lineBreak = "<br>";

    // iterate through each scene
    scenes.forEach((scene, i, scenes) => {
        if (i == scenes.length - 1) {
            lineBreak = "";
        }
        // add the scene id as well as any corresponding shots
        scenesText += scene.id + "<br>" + addShots(scene.shots) + lineBreak;
    });

    var scenes_tag = document.getElementById("scenes");
    scenes_tag.innerHTML = scenesText;
}

// returns shots text
function addShots(shots) {
    let shotsText = "";
    shots.forEach(shot => {
        shotsText += "&emsp;" + shot.id + "<br>";
    });

    return shotsText;
}
