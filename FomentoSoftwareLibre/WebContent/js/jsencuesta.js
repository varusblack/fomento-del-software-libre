function addElement(texto){
	var capa = document.getElementById("capa");
	var h1 = document.createElement("h1");
	h1.innerHTML = texto;
	capa.appendChild(h1);
} 