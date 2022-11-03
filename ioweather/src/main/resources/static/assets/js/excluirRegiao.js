$('#confirmacaoExclusaoModalRegiao').on('show.bs.modal',function(event){
	
	
	var button=$(event.relatedTarget);
	var codigoRegiao=button.data('codigo');
	alert(codigoRegiao)
	
	var nomeRegiao=button.data('descricao');
	
	var modal=$(this);
	var form=modal.find('form');
	var action=form.data('url-base');
	if(!action.endsWith('/')){
		action+='/';
	}
	alert(action + codigoRegiao)
	form.attr('action', action + codigoRegiao);
	modal.find('.modal-body span').html('Tem certeza que deseja excluir a Reião <strong> ' + nomeRegiao + '</strong> ?');
		
	
	
});