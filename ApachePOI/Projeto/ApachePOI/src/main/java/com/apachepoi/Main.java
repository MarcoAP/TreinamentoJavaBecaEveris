package com.apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.apachepoi.dto.Aluno;
import com.apachepoi.utils.ReadFile;

public class Main {

	public static void main(String[] args) throws IOException {

		List<Aluno> listaAlunos = new ArrayList<Aluno>();

		try {
			FileInputStream arquivo = new FileInputStream(ReadFile.getFile());

			HSSFWorkbook workbook = new HSSFWorkbook(arquivo);

			HSSFSheet sheetAlunos = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheetAlunos.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				Aluno aluno = new Aluno();
				listaAlunos.add(aluno);
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getColumnIndex()) {
					case 0:
						aluno.setNomeAluno(cell.getStringCellValue());
						break;
					case 1:
						aluno.setNotaProva1(String.valueOf(cell.getNumericCellValue()));
						break;
					case 2:
						aluno.setNotaProva2(cell.getNumericCellValue());
						break;
					case 3:
						aluno.setMedia(cell.getNumericCellValue());
						break;
					case 4:
						aluno.setParticipacao(cell.getNumericCellValue());
						break;
					case 5:
						aluno.setMediaFinal(cell.getNumericCellValue());
						break;
					}
				}
			}
			arquivo.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (listaAlunos.size() == 0) {
			System.out.println("Nenhum aluno encontrado!");
		} else {
			double soma = 0;
			double maior = 0;
			double menor = listaAlunos.get(0).getMedia();
			int aprovados = 0;
			int reprovados = 0;
			for (Aluno aluno : listaAlunos) {
				System.out.println("Aluno: " + aluno.getNomeAluno() + " Média: " + aluno.getMediaFinal());
				soma = soma + aluno.getMedia();
				if (aluno.getMedia() > maior) {
					maior = aluno.getMedia();
				}
				if (aluno.getMedia() < menor) {
					menor = aluno.getMedia();
				}
				if (aluno.getMedia() >= 6) {
					aprovados++;
				}
				if (aluno.getMedia() < 6) {
					reprovados++;
				}
			}
			double media = soma / listaAlunos.size();
			System.out.println("A media de notas e: " + media);
			System.out.println("A maior nota e: " + maior);
			System.out.println("A menor nota e: " + menor);
			System.out.println("O numero de alunos aprovados e: " + aprovados);
			System.out.println("O numero de alunos reprovados e: " + reprovados);
			System.out.println("Número total de alunos: " + listaAlunos.size());
		}

	}

}
