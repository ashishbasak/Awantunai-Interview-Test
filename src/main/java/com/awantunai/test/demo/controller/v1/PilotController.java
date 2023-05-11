package com.awantunai.test.demo.controller.v1;

import com.awantunai.test.demo.entity.Pilot;
import com.awantunai.test.demo.service.PilotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/pilots")
@RequiredArgsConstructor
public class PilotController {

  private final PilotService pilotService;

  @GetMapping("/{pilotId}")
  public Pilot getById(@PathVariable(name = "pilotId") Integer pilotId) {

  }
}
