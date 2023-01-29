src="https://cdn.maptiler.com/maplibre-gl-js/v2.4.0/maplibre-gl.js"


const key = 'cdBiwf2qy8aq6PBqrH8p';
const map = new maplibregl.Map({
    container: 'map', // container id
    style: `https://api.maptiler.com/maps/streets-v2/style.json?key=${key}`, // style URL
    center: [23.318998724, 42.673830638], // starting position [lng, lat]
    zoom: 12 // starting zoom
});
map.addControl(new maplibregl.NavigationControl(), 'top-right');
map.on('error', function(err) {
    throw new Error("To load the map, you must replace YOUR_MAPTILER_API_KEY_HERE first, see README");
});