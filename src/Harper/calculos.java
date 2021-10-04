
package calculos_jose;


public class calculos {
    public double Ar_Total , Profund_Media, Indice_corecao, Area_R_Corrig, P_H_altura
            , Ar_Sub_Lote, Ar_Lote_Ind;
    
    public double area_total (float H_altura, float Testada){
        Ar_Total = H_altura/Testada;
        P_H_altura = H_altura;
        //System.out.println("Area total: "+Ar_Total);
        return Ar_Total;
    }
    public double profundidade_media (float pp){
        Profund_Media = pp/Ar_Total;
        //System.out.println("Profundidade: "+Profund_Media);
        return Profund_Media;
    }
    
    public double indice_correcao(){
        Indice_corecao = Math.sqrt(Profund_Media);
        //System.out.println("Índice: "+Indice_corecao);
        return Indice_corecao;
    }
    public double area_corrigida (){
        Area_R_Corrig = P_H_altura * Indice_corecao;
        //System.out.println("Area Real Corrigida: "+Area_R_Corrig+"\n\tP_H_Altura: "+P_H_altura
               // +"\n\tíndice de correção: "+Indice_corecao);
        return Area_R_Corrig;
    }
    //sub lote cálculos
    public double area_sub_lote (double produto_casas, double Area_corr){
        Ar_Sub_Lote = Area_corr/produto_casas;
       // System.out.println("Área do Sub Lote: "+Ar_Sub_Lote+"\n\tÁrea real corrigida: "
      //          +Area_R_Corrig+"\n\tProduto das casas: "+produto_casas);
        return Ar_Sub_Lote;
    }
    public double A_Lote_Indiv (float ar_casa){
        Ar_Lote_Ind = ar_casa * Ar_Sub_Lote;
       // System.out.println("Área do Lote Individual: "+Ar_Lote_Ind);
        return Ar_Lote_Ind;
    }
}
