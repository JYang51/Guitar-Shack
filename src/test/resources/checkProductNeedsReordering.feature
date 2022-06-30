Feature: Check product needs re-ordering

  Scenario Outline: Product needs re-ordering
    Given A product with stock level of <stock level>, description of <description> and a buffer of <buffer>
    When The <product> is purchased in a <quantity> that lowers the stock level to or below the buffer
    Then A <notification> is sent to the store manager to order more product

    Examples: of product sales
      | product | stock level | description                                                  | buffer | quantity | notification                                                                                     |
      | 811     | 37          | "Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst" | 20     | 17       | "Please order more of product 811: 'Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst'" |

  Scenario Outline: Product doesn't need re-ordering
    Given A product with stock level of <stock level>, description of <description> and a buffer of <buffer>
    When The <product> is purchased in a <quantity> that keeps the stock level above the buffer
    Then No notification sent to the store manager

    Examples: of product sales
      | product | stock level | description                                                  | buffer | quantity |
      | 811     | 37          | "Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst" | 20     | 16       |

  Scenario Outline: Product is on order
    Given A product with stock level of <stock level>, description of <description> and a buffer of <buffer>
    When a <quantity> of the <product> is purchased
    Then No notification sent to the store manager

    Examples: of product sales
      | product | stock level | description                                                  | buffer | quantity |
      | 811     | 20          | "Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst" | 20     | 5        |