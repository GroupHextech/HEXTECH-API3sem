$('#confirmacaoExclusaoModalEstacao').on('show.bs.modal',function(event){
	
	
	var button=$(event.relatedTarget);
	var codigoEstacao=button.data('codigo');
	alert(codigoEstacao)
	
	var nomeEstacao=button.data('descricao');
	
	var modal=$(this);
	var form=modal.find('form');
	var action=form.data('url-base');
	if(!action.endsWith('/')){
		action+='/';
	}
	alert(action + codigoEstacao)
	form.attr('action', action + codigoEstacao);
	modal.find('.modal-body span').html('Tem certeza que deseja excluir a estaçao <strong> ' + nomeEstacao + '</strong> ?');
		
	
	
});