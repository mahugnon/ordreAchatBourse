$(document)
		.ready(
				function() {
					console.log("Allo js")
					$("#idClientError").hide();
					$("#idCompteError").hide();
					$('#codeISBNError').hide();
					$("#codeISBNError").hide();
					$("#reponse").hide();
					$("#nouveauClient").hide();
					$("#ordreforme").submit(function(event) {
						event.preventDefault();
						var data = $("#ordreforme").serialize();
						console.log(data);
						emettreOrdre(data);
					});
					$("#inscriptionForm").submit(function(event) {
						event.preventDefault();
						var data = $("#inscriptionForm").serialize();
						console.log(data);
						creerClient(data);
					});
					$("#creerTarif").submit(function() {
						event.preventDefault();
						var data = $("#creerTarif").serialize();
						creerTarif(data);
						console.log(data)
					});

					$("#idClient")
							.change(
									function() {
										$
												.ajax({
													dataType : "json",
													url : '/client/'
															+ $("#idClient")
																	.val(),

													type : 'GET',
													success : function(res,
															status, xhr) {
														$("#idClientError")
																.hide();
														console.log(status)
													},
													error : function() {
														$("#idClientError")
																.html(
																		"Je ne vous trouve pas. Veillez vous inscrire")
														$("#idClientError")
																.show();
													}
												});
									});

					$("#idCompte")
							.change(
									function() {
										$
												.ajax({
													dataType : "json",
													url : 'client/compte/'
															+ $("#idCompte")
																	.val(),

													type : 'GET',
													data : {
														idCl : $("#idClient")
																.val()
													},
													success : function(res,
															status, xhr) {
														$("#idCompteError")
																.hide();
													},
													error : function(err) {
														$("#idCompteError")
																.html(
																		"Le compte n'existe pas ou bien vous n'ête pas le propriétaire de ce compte");
														$("#idCompteError")
																.show();
													}
												});
									});
					$('#codeISBN')
							.change(
									function() {
										$
												.ajax({
													dataType : "json",
													url : '/client/instrument/'
															+ $("#codeISBN")
																	.val(),

													type : 'GET',
													success : function(res,
															status, xhr) {
														$("#codeISBNError")
																.hide();
													},
													error : function(err) {
														$("#codeISBNError")
																.html(
																		"L'instrument rechercher n'existe pas");
														$("#codeISBNError")
																.show();
													}
												});
									});

					$("#inscription").click(function() {
						$("#ordrewrapper").hide();
						$("#nouveauClient").show();
					});
					$("#retourOrdre").click(function() {
						$("#nouveauClient").hide();
						$("#ordrewrapper").show();
					});
				});
function emettreOrdre(data) {
	$('#reponse').hide();
	$('#reponse').removeClass('label label-danger');
	$('#reponse').removeClass('label label-success');

	$.ajax({
		dataType : "json",
		url : '/client/ordre',

		type : 'POST',
		data : data,
		success : function(res, status, xhr) {
			console.log(res);
			if (res.msg == 'succes') {
				$('#reponse').removeClass('label label-danger');
				$('#reponse').addClass('label label-success');
				$('#reponse').html('Success ordre');
				$('#reponse').show();
			} else {
				$('#reponse').removeClass('label label-success');
				$('#reponse').addClass('label label-danger');
				$('#reponse').html('' + res.msg);
				$('#reponse').show();
			}
		},
		error : function(err) {
			console.log(err);
		}
	});
}
function creerClient(data) {
	$.ajax({
		dataType : "json",
		url : '/client/nouveau_client',

		type : 'POST',
		data : data,
		success : function(res, status, xhr) {
			alert("succès");
			$("#nouveauClient").hide();
			$("#ordrewrapper").show();
		},
		error : function(err) {
			console.log(err);
		}
	});
}
function creerTarif(data){
	$.ajax({
		dataType : "json",
		url : '/admin/tarif',

		type : 'POST',
		data : data,
		success : function(res, status, xhr) {
			alert("succès");
		},
		error : function(err) {
			console.log(err);
		}
	});
}
