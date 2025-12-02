Ranking (Top N per Group):
Question: "Find the top 3 highest transactions for each account."
Code: DENSE_RANK() OVER (PARTITION BY account_id ORDER BY amount DESC)

SELECT account_id, transactions_id, amount
FROM (
    SELECT account_id, transactions_id, amount,
        DENSE_RANK() OVER (PARTITION BY account_id ORDER BY amount DESC) as rank_num
    FROM
        Transactions
) AS ranked_transactions
WHERE
    rank_num <= 3;


Time Series Analysis (Lead/Lag):
Question: "Find all days where the stock price was higher than the previous day."
Code: Use LAG(price, 1) OVER (ORDER BY date) to get yesterday's price on the same row as today's.

SELECT
    date,
    price AS current_price
FROM (
    SELECT
        date,
        price,
        -- LAG retrieves the price from the row 1 position before the current row (yesterday).
        LAG(price, 1) OVER (
            ORDER BY date
        ) AS previous_day_price
    FROM
        StockPrices
) AS daily_comparison
-- Filter where today's price is strictly greater than yesterday's price.
WHERE
    price > previous_day_price
ORDER BY
    date;


Moving Averages:
Question: "Calculate the 3-day rolling average of trade volume."
Code: AVG(volume) OVER (ORDER BY date ROWS BETWEEN 2 PRECEDING AND CURRENT ROW)

SELECT
    date,
    volume,
    -- Calculates the average volume for the current row and the 2 preceding rows.
    AVG(volume) OVER (
        ORDER BY date
        ROWS BETWEEN 2 PRECEDING AND CURRENT ROW
    ) AS three_day_avg_volume
FROM
    StockPrices
ORDER BY
    date;

Scenario 1: The "Self-Join" (Manager Hierarchy)
Question: "You have an Employees table with id, name, salary, and manager_id. Write a query to find all employees who earn more than their own manager."

The Solution:
SELECT e.name
FROM Employees e
JOIN Employees m ON e.manager_id = m.id
WHERE e.salary > m.salary;

Scenario 2: The "Duplicate Cleaner"
Question: "A bug in our ingestion script created duplicate user records in the Users table (same email, different id). Write a SQL query to delete the duplicates but keep the one with the lowest ID."

The Solution (CTE + Window Function):

WITH CTE AS (
    SELECT id,
           ROW_NUMBER() OVER (PARTITION BY email ORDER BY id ASC) as rn
    FROM Users
)
DELETE FROM CTE WHERE rn > 1;