package org.deuce.benchmark.examples.intset;

import java.util.Random;

import org.deuce.transform.Exclude;

@Exclude
public class Benchmark implements benchmark.Benchmark {

	IntSet m_set;
	int m_range = 1 << 16;
	int m_rate = 20;

	public void init(String[] args) {
		boolean error = false;
		int initial = 256;

		if (args.length > 0) {
			if (args[0].equals("OOP"))
				m_set = new IntSetOOP();
			else
				error = true;
		} else
			error = true;
		for (int i = 1; i < args.length && !error; i++) {
			if (args[i].equals("-i")) {
				if (++i < args.length)
					initial = Integer.parseInt(args[i]);
				else
					error = true;
			} else if (args[i].equals("-r")) {
				if (++i < args.length)
					m_range = Integer.parseInt(args[i]);
				else
					error = true;
			} else if (args[i].equals("-w")) {
				if (++i < args.length)
					m_rate = Integer.parseInt(args[i]);
				else
					error = true;
			} else
				error = true;
		}
		if (error) {
			System.out.println("Benchmark arguments: (NoAOP|AOP|OOP|RBTree|Skip) [-i initial-size] [-r range] [-w write-rate]");
			System.exit(1);
		}
		Random random = new Random();
		for (int i = 0; i < initial; i++)
			m_set.add(random.nextInt(m_range));
		System.out.println("Initial size        = " + initial);
		System.out.println("Range               = " + m_range);
		System.out.println("Write rate          = " + m_rate + "%");
		System.out.println();
	}

	public benchmark.BenchmarkThread createThread(int i) {
		return new BenchmarkThread(m_set, m_range, m_rate);
	}

	public String stats(benchmark.BenchmarkThread[] threads) {
		int add = 0;
		int remove = 0;
		int contains = 0;
		for (int i = 0; i < threads.length; i++) {
			add += ((BenchmarkThread)threads[i]).m_nb_add;
			remove += ((BenchmarkThread)threads[i]).m_nb_remove;
			contains += ((BenchmarkThread)threads[i]).m_nb_contains;
		}
		return "A=" + add + ", R=" + remove + ", C=" + contains;
	}
}
