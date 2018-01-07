package br.com.stefaninids.projetods.tools.util;

import java.io.File;
import java.io.IOException;

import br.com.stefaninids.projetods.entities.Usuario;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Excel {
	String filename = "";
    WorkbookSettings ws;
    WritableWorkbook workbook;
    WritableFont wf;
    WritableCellFormat cf;
    
	public Excel(Usuario usuario) throws WriteException {
		ws = new WorkbookSettings();
		wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
		cf = new WritableCellFormat(wf);
	    cf.setWrap(true);
	    filename = "importacao_" + Long.toString(usuario.getTableId().getId()) + "_envios.xls";	    
	}
	
	private void criarWorkbook() throws IOException {		
		workbook = Workbook.createWorkbook(new File(filename), ws);
	}
	
	public String finalizarWorkbook() throws IOException, WriteException {
		workbook.write();
		workbook.close();  
		return filename;
	}
	
	public WritableSheet criarPlanilha() throws IOException, RowsExceededException, WriteException {
		criarWorkbook();
		WritableSheet s = workbook.createSheet("planilha", 0);		
		
		escreverDados(0, 0, "Nome do Arquivo", s);
		escreverDados(1, 0, "Tipo do Arquivo", s);
		escreverDados(2, 0, "Texto Procurado", s);
		escreverDados(3, 0, "Número de Ocorrências", s);
		escreverDados(4, 0, "Usuário Upload", s);
		escreverDados(5, 0, "Tipo Captura", s);
				
		return s;
	}
	
	public void escreverDados(int coluna, int linha, String texto, WritableSheet s) throws RowsExceededException, WriteException {
		s.addCell(new Label(coluna, linha, texto, cf));
	}
}
