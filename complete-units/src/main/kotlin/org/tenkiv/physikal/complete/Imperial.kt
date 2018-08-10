/*
 * Copyright 2018 Tenkiv, Inc.
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
package org.tenkiv.physikal.complete

import systems.uom.ucum.UCUM
import tec.units.indriya.ComparableQuantity
import tec.units.indriya.quantity.Quantities
import javax.measure.quantity.Temperature

/**
 * Builder method for [ComparableQuantity] with unit [UCUM.RANKINE].
 *
 * @return A [ComparableQuantity] with specified value.
 */
val Number.rankine: ComparableQuantity<Temperature>
    get() = Quantities.getQuantity<Temperature>(this, UCUM.RANKINE)

/**
 * Builder method for [ComparableQuantity] with unit [UCUM.FAHRENHEIT].
 *
 * @return A [ComparableQuantity] with specified value.
 */
val Number.fahrenheit: ComparableQuantity<Temperature>
    get() = Quantities.getQuantity<Temperature>(this, UCUM.FAHRENHEIT)
