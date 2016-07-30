<div class="modal fade" id="visitaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Fechar</span>
                </button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
                <div class="error"></div>
                <form class="form-horizontal">
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-4">
                                <label class="control-label" for="txtData">Dia</label>
                                <input id="txtData" name="data" type="text" class="form-control input-md" />
                            </div>
                            <div class="col-md-4"></div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-4">
                                <label class="control-label" for="txtHora">Horário</label>
                                <div class="input-append bootstrap-timepicker">
                                    <input id="txtHora" name="hora" type="text"  class="form-control input-md" />
                                </div>
                            </div>
                            <div class="col-md-4"></div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-2"></div>
                            <div class="col-md-8" id="panComboTecnico">
                                <label class="control-label" for="comboTecnico">Técnico</label>
                                <input class="form-control" id="comboTecnico"/>
                            </div>
                            <div class="col-md-2"></div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-2"></div>
                            <div class="col-md-8" id="panComboFamilia">
                                <label class="control-label" for="comboFamilia">Família</label>
                                <input class="form-control" id="comboFamilia"/>
                            </div>
                            <div class="col-md-2"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="colorPicker">Cor</label>
                        <div class="col-md-4">
                            <input id="colorPicker" name="color" type="text" class="form-control input-md" readonly="readonly" />
                            <span class="help-block">Clique para escolher uma cor</span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
</div>