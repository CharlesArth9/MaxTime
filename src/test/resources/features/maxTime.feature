Feature: Hacer el maxTime de manera automatizada
  @Max
  Scenario: ingreso a maxtime y se realiza el reporte del dia
    Given ingreso a MaxTime
    When realizo el reporte del dia
    Then verifico el cierre del dia de manera correcta


