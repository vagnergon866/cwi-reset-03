package br.com.cwi.reset.vagnergoncalves.domain;

public enum StatusCarreira {
    EM_ATIVIDADE("Em atividade"),
    APOSENTADO("Aposentado");

  StatusCarreira(String status){
      this.status = status;

  }
  private String status;
  public String getStatus(){
      return status;
  }

}
