package com.toy.graphql.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {

	@Async
	public void async() throws InterruptedException {
		log.info("async-start");
		Thread.sleep(3000);
		log.info("async-end");
	}
}
