package io.github.vihangpatil.kotlintricks.range

/**
 * @param[other] [ClosedRange]<[T]>
 * @return [Boolean] if this [Comparable]<[T]> overlaps with [other]
 */
private fun <T : Comparable<T>> ClosedRange<T>.overlapsWith(
        other: ClosedRange<T>
): Boolean {
    return (other.start in start..endInclusive || other.endInclusive in start..endInclusive)
}

/**
 * @param[other] [ClosedRange]<[T]>
 * @return [Collection]<[ClosedRange]<[T]>> with [this] and [other] if they do not overlap, or with just one merged
 *   [ClosedRange]<[T]> if they overlap.
 */
private fun <T : Comparable<T>> ClosedRange<T>.mergeWith(
        other: ClosedRange<T>
): Collection<ClosedRange<T>> {

    // if they do not overlap
    return if (!overlapsWith(other)) {
        // then return them separately
        listOf(this, other)
    } else {
        // else merge them
        listOf(minOf(start, other.start)..maxOf(endInclusive, other.endInclusive))
    }
}

/**
 * @return [Collection]<[ClosedRange]<[T]>> with overlapping [ClosedRange]<[T]> merged.
 */
fun <T : Comparable<T>> Collection<ClosedRange<T>>.mergeRanges(): Collection<ClosedRange<T>> {
    // no changes for empty collection or collection with single element
    if (this.size < 2) {
        return this
    }
    return sortedBy { it.start } // sort by start of range
            .fold(initial = emptyList()) { list: List<ClosedRange<T>>, element: ClosedRange<T> ->
                if (list.isEmpty()) {
                    // for first element
                    listOf(element)
                } else {
                    // Attempt to merge last of the list with the element.
                    // If they are overlapping, [mergeWith] will return collection with single merged element.
                    // Or else, it will return list with two elements.
                    list.last().mergeWith(element) +
                            // drop last element to avoid it to be duplicate
                            list.dropLast(1)
                }
            }
}

/**
 * @param[asRange] Function to map [E] to [ClosedRange]<[T]>.
 * @param[asElement] Function to map [ClosedRange]<[T]> to [E].
 * @return [Collection]<[E]> with overlapping [ClosedRange]<[T]> merged.
 */
fun <E, T : Comparable<T>> Collection<E>.mergeBy(
        asRange: (E) -> ClosedRange<T>,
        asElement: (ClosedRange<T>) -> E
): Collection<E> {

    // no changes for empty collection or collection with single element
    if (this.size < 2) {
        return this
    }
    return sortedBy { element -> // sort by start of range
        asRange(element).start
    }.fold(initial = emptyList()) { list: List<E>, element: E ->
        if (list.isEmpty()) {
            // for first element
            listOf(element)
        } else {
            // Attempt to merge last of the list with the element.
            // If they are overlapping, [mergeWith] will return collection with single merged element.
            // Or else, it will return list with two elements.
            asRange(list.last()).mergeWith(asRange(element)).map(asElement) +
                    // drop last element to avoid it to be duplicate
                    list.dropLast(1)
        }
    }
}
