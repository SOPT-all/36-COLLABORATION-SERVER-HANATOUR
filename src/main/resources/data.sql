-- 1. PACKAGE (ID는 auto_increment이므로 생략)
INSERT INTO package (
    title, type, hotel_grade, companion, price,
    include_flight, is_group, description, image_url
)
VALUES (
           '동유럽 5개국 10일', '골프', '5성급', '친구모임', 2790000,
           TRUE, TRUE, '자연이 만든 걸작, 두 섬의 품격 있는 여정', 'https://imagesample.com'
       );

-- 2. DISCOUNT
INSERT INTO discount (
    package_id, discount_type
)
VALUES (
           1, 'RUN'
       );

-- 3. SCHEDULE
INSERT INTO schedule (
    package_id, depart_date, arrive_date, departure, arrival
)
VALUES (
           1, TIMESTAMP '2025-06-01 10:00:00', TIMESTAMP '2025-06-10 19:00:00', 'Seoul', 'Tokyo'
       );

-- 4. CONDITION
INSERT INTO condition (
    package_id, is_free, is_choice, is_guide, is_guide_fee, is_shop
)
VALUES (
           1, FALSE, TRUE, TRUE, FALSE, TRUE
       );

-- 5. TAG
INSERT INTO tag (
    package_id, tag_name1, tag_name2, tag_name3
)
VALUES (
           1, 'PACKAGE', 'GOLF', 'PREMIUM'
       );
