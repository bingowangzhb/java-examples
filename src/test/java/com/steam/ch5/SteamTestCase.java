package com.steam.ch5;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public class SteamTestCase {


    @Test
    public void practiseSteam() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("--------------------1---------------------");
        // 1
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("---------------------2--------------------");
        // 2
        traders.stream()
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

        System.out.println("---------------------3--------------------");
        traders.stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .map(Trader::getName)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);


        System.out.println("---------------------4--------------------");


        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .forEach(System.out::print);


        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(joining());
        System.out.println();
        System.out.println(traderStr);
        System.out.println();
        System.out.println("---------------------5--------------------");
        traders.stream()
                .filter(trader -> !trader.getCity().equals("Milan"))
                .map(Trader::getName)
                .forEach(System.out::println);
        System.out.println("---------------------6--------------------");
        int tt = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, Math::addExact);
        System.out.println(tt);
        System.out.println("---------------------7--------------------");
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max).ifPresent(System.out::println);

        System.out.println("---------------------8--------------------");
        transactions.stream()
                .min(comparing(Transaction::getValue))
                .map(Transaction::getValue)
                .ifPresent(System.out::println);

    }

}
