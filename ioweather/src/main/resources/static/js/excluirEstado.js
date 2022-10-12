$('#confirmacaoExclusaoModalEstado').on('show.bs.modal',function(event){
	
	
	var button=$(event.relatedTarget);
	var codigoEstado=button.data('codigo');
	alert(codigoEstado)
	
	var nomeEstado=button.data('descricao');
	
	var modal=$(this);
	var form=modal.find('form');
	var action=form.data('url-base');
	if(!action.endsWith('/')){
		action+='/';
	}
	alert(action + codigoEstado)
	form.attr('action', action + codigoEstado);
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o Estado <strong> ' + nomeEstado + '</strong> ?');
		
	
	
});