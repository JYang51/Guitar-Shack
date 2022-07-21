package com.guitarshack.unittests;

import com.guitarshack.AverageDailySales;
import com.guitarshack.Buffer;
import com.guitarshack.Product;
import com.guitarshack.StockBuffer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BufferTests {
    @Test
    void bufferIsLeadTimeMultipliedByAverageDailySales() {
        AverageDailySales averageDailySales = product -> 0.5;
        Buffer bufferCalculator = new StockBuffer(averageDailySales);
        int buffer = bufferCalculator.calculate(new Product(1, "", 7, 811));

        assertEquals(4, buffer);
    }
}
