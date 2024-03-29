package com.hustbill;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import static java.util.stream.StreamSupport.stream;

/**
 * 
 * @author Hua Zhang
 * @param <T>
 */
public class FixedBatchSpliterator<T> extends FixedBatchSpliteratorBase<T> {

	private final Spliterator<T> spliterator;

	public FixedBatchSpliterator(Spliterator<T> toWrap, int batchSize, long est) {
		super(toWrap.characteristics(), batchSize, est);
		this.spliterator = toWrap;
	}

	public FixedBatchSpliterator(Spliterator<T> toWrap, int batchSize) {
		this(toWrap, batchSize, toWrap.estimateSize());
	}

	public FixedBatchSpliterator(Spliterator<T> toWrap) {
		this(toWrap, 64, toWrap.estimateSize());
	}

	public static <T> Stream<T> withBatchSize(Stream<T> in, int batchSize) {
		return stream(new FixedBatchSpliterator<>(in.spliterator(), batchSize), true);
	}

	public static <T> FixedBatchSpliterator<T> batchedSpliterator(Spliterator<T> toWrap, int batchSize) {
		return new FixedBatchSpliterator<>(toWrap, batchSize);
	}

	@Override
	public boolean tryAdvance(Consumer<? super T> action) {
		return spliterator.tryAdvance(action);
	}

	@Override
	public void forEachRemaining(Consumer<? super T> action) {
		spliterator.forEachRemaining(action);
	}
}
