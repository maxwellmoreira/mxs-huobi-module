package com.mxs.huobi.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.mxs.huobi.factory.FeignFactory;
import com.mxs.huobi.response.CandlestickClientResponse;
import com.mxs.huobi.util.Util;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = FeignFactory.class)
public class CandlestickClientTest {
    @Autowired
    private CandlestickClient candlestickClient;
    @Value("${wiremock.server.port}")
    private int wiremockPort;
    private WireMockServer wireMockServer;

    @BeforeAll
    public void beforeAll() {
        wireMockServer = new WireMockServer(wiremockPort);
        wireMockServer.start();
    }

    @BeforeEach
    public void beforeEach() {
        wireMockServer.resetAll();
    }

    @AfterAll
    public void afterAll() {
        wireMockServer.stop();
    }

    @Test
    void listCandlestick() throws IOException {
        String candlestickStubResponse = Util.getJsonAsString("json/candlestick_stub_response.json");

        CandlestickClientResponse expected = (CandlestickClientResponse) Util.getJsonAsObject(
                "json/candlestick_stub_response.json", CandlestickClientResponse.class);

        wireMockServer.stubFor(get("/market/history/kline?symbol=btcusdt&period=60min&size=6")
                .willReturn(ok().withHeader("Content-Type", "application/json")
                        .withBody(candlestickStubResponse)
                        .withStatus(HttpStatus.OK.value())));

        CandlestickClientResponse actual =
                candlestickClient.listCandlestick("btcusdt", "60min", 6);

        Assertions.assertEquals(expected.getData().size(), actual.getData().size());
    }
}
