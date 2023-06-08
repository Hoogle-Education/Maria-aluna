package br.eti.arthurgregorio.contadorvendas;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStreamReader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.time.Month;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SalesReader {

    private final List<Sale> sales;

    public SalesReader(String salesFile) {

        final var dataStream = ClassLoader.getSystemResourceAsStream(salesFile);

        if (dataStream == null) {
            throw new IllegalStateException("File not found or is empty");
        }

        final var builder = new CsvToBeanBuilder<Sale> (new InputStreamReader(dataStream, StandardCharsets.ISO_8859_1));

        sales = builder
                .withType(Sale.class)
                .withSeparator(';')
                .build()
                .parse();
    }

    public int totalOfCompletedSales() {
        Stream <Sale> st = sales.stream();
        List<Sale> lst = st.filter( s -> s.getStatus() == Sale.Status.COMPLETED).collect(Collectors.toList());
        return lst.size();
    }

    public void totalOfCancelledSales() {
        // TODO qual o valor total de vendas canceladas?
    }

    public void mostRecentCompletedSale() {
        // TODO qual a venda mais recente?
    }

    public void daysBetweenFirstAndLastCancelledSale() {
        // TODO encontre a quantidade de dias entre a primeira e a ultima venda cancelada
    }

    public void totalCompletedSalesBySeller(String sellerName) {
        // TODO qual o valor de vendas completas para o vendedor informado?
    }

    public void countAllSalesByManager(String managerName) {
        // TODO quantas vendas a equipe do gerente informado fez?
    }

    public void totalSalesByStatusAndMonth(Sale.Status status, Month... months) {
        // TODO qual o total de vendas nos meses informados com o status indicado?
    }

    public void countCompletedSalesByDepartment() {
        // TODO qual quantidade de vendas por departamento?
    }

    public void countCompletedSalesByPaymentMethodAndGroupingByYear() {
        // TODO qual a quantidade de vendas por metodo de pagamento por ano?
    }

    public void top3BestSellers() {
        // TODO um ranking com os 3 melhores vendedores com base no valor total de vendas
    }

    /*
     * Use esse metodo para converter objetos BigDecimal para uma represetancao de moeda
     */
    private String toCurrency(BigDecimal value) {
        return NumberFormat.getInstance().format(value);

}
