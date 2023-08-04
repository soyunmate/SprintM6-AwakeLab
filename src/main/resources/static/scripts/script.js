"use strict";
const menuPrincipal = document.querySelector(".btn-menu-principal");
const tipoUsuario = document.getElementById("tipoUsuario");
const adminViews = document.querySelectorAll(".admin-view");
const clientViews = document.querySelectorAll(".client-view");
const profViews = document.querySelectorAll(".prof-view");
const allViews = [adminViews,clientViews,profViews];

const btnEnviar = document.querySelector(".btn-enviar-form");
const extraField1 = document.querySelector(".extra-field1");
const extraField2 = document.querySelector(".extra-field2");
const extraField3 = document.querySelector(".extra-field3");
const btnsTipo = document.querySelectorAll(".btn-tipo");
const camposOpcionales = document.querySelectorAll(".opcional");
camposOpcionales.forEach(co => co.style.display = "none");

const rut = document.querySelector(".opt-rut");
const titulo = document.querySelector(".opt-titulo");
const area = document.querySelector(".opt-area");




//Formulario

/*
btnsTipo.forEach(c => {
	console.log(c.textContent);
	c.addEventListener("click", function() {
			btnEnviar.style.display = "block";
			if (c.textContent === "Cliente") {
				rut.style.display = "block";
				titulo.style.display = "none";
				area.style.display = "none";
				extraField1.setAttribute('required', 'required');
				extraField2.removeAttribute('required');
				extraField3.removeAttribute('required');
				
				
				
			}
			if (c.textContent === "Profesional") {
				rut.style.display = "none";
				titulo.style.display = "block";
				area.style.display = "none";
				extraField1.removeAttribute('required');
				extraField2.setAttribute('required', 'required');
				extraField3.removeAttribute('required');
			
			}
			if (c.textContent === "Administrativo") {
				rut.style.display = "none";
				titulo.style.display = "none";
				area.style.display = "block";
				extraField1.removeAttribute('required');
				extraField2.removeAttribute('required');
				extraField3.setAttribute('required', 'required');
				
			}
		
	})
	
})
*/
//Refactor

const optFields = [rut,titulo,area];
const optFieldsInputs = [extraField1,extraField2,extraField3]; 


btnsTipo.forEach((btn,i) => {
	btn.addEventListener("click", function(e) {
		
		//if (btn.textContent === e.target.textContent) {
			optFields.forEach((cmp, j) => i === j ? cmp.style.display = "block" : cmp.style.display = "none"  )
			optFieldsInputs.forEach((inp,j) => i === j ? inp.setAttribute('required', 'required') : inp.removeAttribute('required')  )
		//}
		
	})
})


//guardar valor formulario
btnsTipo.forEach(bt => {
	  bt.addEventListener("change", function() {
		  document.getElementById("TipoUsuario").value = this.value;
	  })
  })


// magia admin->client->prof

const hideView = function(arr) {
	arr.forEach(e => {
		e.style.display = "none";
	})
}

const showView = function(arr) {
	arr.forEach(e => {
		e.style.display = "block";
	})
}


menuPrincipal.addEventListener("click", function () {
	const tipos = ["Administrativo", "Cliente", "Profesional" ];
	
	
	
	
	tipos.forEach((tp,i) => {
		tp === tipoUsuario.textContent.trim() ? showView(allViews[i]) : hideView(allViews[i]);
	})
	
	if (tipoUsuario.textContent.trim() === "serverAdmin") {
		tipos.forEach((tp,i) => showView(allViews[i]) );
	}
	
	
	
	/*
	if (tipoUsuario.textContent.trim() === tipos[0]) {
		console.log("work")
		hideView(clientViews);
		hideView(profViews);
		showView(adminViews)
		
		allViews.forEach(vw => {
			
		})
		
	}
	if (tipoUsuario.textContent.trim() === tipos[1]) {
		console.log("work")
		hideView(adminViews);
		hideView(profViews);
		showView(clientViews)
	}
	if (tipoUsuario.textContent.trim() === tipos[2]) {
		console.log("work")
		hideView(clientViews);
		hideView(adminViews);
		showView(profViews)
	}
	
	if (tipoUsuario.textContent.trim() === "ServerAdmin") {
		console.log("work")
		showView(clientViews);
		showView(adminViews);
		showView(profViews)
	}
	*/
	
});


// Modal Edit user 
const userIdform = document.getElementById("user-id-form-field");
const userIdValue = document.getElementById("hidden-user-id");
const btnsEdit = document.querySelectorAll(".edit-user-btn");
const inputNombre = document.querySelector(".inputNombre");
btnsEdit.forEach(btn => {
	btn.addEventListener("click", function() {
		
		userIdform.textContent = btn.dataset.userId;
		userIdValue.value = userIdform.textContent;
		inputNombre.value = btn.dataset.usernombre;
		
	})
})


// Modal delete user:
const userDelId = document.getElementById("user-id-form-field-delete");
const userDelValues = document.getElementById("hidden-user-id-delete");
const btnsDelete = document.querySelectorAll(".delete-user-btn");

btnsDelete.forEach(btn => {
	
	btn.addEventListener("click", function() {
		//const id = btn.dataset.userId;
		userDelId.textContent = btn.dataset.userId;
		userDelValues.value = userDelId.textContent;
		
	})
	
})

