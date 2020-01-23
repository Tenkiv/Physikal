/*
 * Copyright 2020 Tenkiv, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package physikal

interface Quantity<QT : Quantity<QT>> : Comparable<Quantity<QT>> {
    val value: Double
    val unit: PhysicalUnit<QT>

    fun convertToCanonical(): Quantity<QT>

    override fun compareTo(other: Quantity<QT>): Int =
        this.convertToCanonical().value.compareTo(other.convertToCanonical().value)
}

operator fun <QT : Quantity<QT>> Quantity<QT>.unaryPlus(): Quantity<QT> = unit.quantityFromValue(+this.value)

operator fun <QT : Quantity<QT>> Quantity<QT>.unaryMinus(): Quantity<QT> = unit.quantityFromValue(-this.value)

operator fun <QT : Quantity<QT>> Quantity<QT>.inc() = unit.quantityFromValue(this.value + 1)

operator fun <QT : Quantity<QT>> Quantity<QT>.dec() = unit.quantityFromValue(this.value - 1)

operator fun <QT : Quantity<QT>> Quantity<QT>.plus(other: Quantity<QT>): Quantity<QT> =
    this.unit.quantityFromValue(this.value + other.convertTo(this.unit).value)

operator fun <QT : Quantity<QT>> Quantity<QT>.minus(other: Quantity<QT>): Quantity<QT> =
    this.unit.quantityFromValue(this.value - other.convertTo(this.unit).value)

infix fun <QT : Quantity<QT>> Quantity<QT>.convertTo(unit: PhysicalUnit<QT>): Quantity<QT> =
    unit.quantityFromCanonicalValue(this.convertToCanonical().value)

interface PhysicalUnit<QT : Quantity<QT>> {
    val symbol: String
    val isCanonical: Boolean

    fun quantityFromValue(value: Double): Quantity<QT>

    fun quantityFromCanonicalValue(value: Double): Quantity<QT>
}