SELECT *
FROM t_admin;

SELECT *
FROM t_menu;


INSERT INTO t_menu (id, text, url, icon, father_id) VALUES
  ('3d186b5934c04559ad9c8baf6d545777', '持明法州之 用户', '', '2012081511913', NULL),
  ('7d89f292e71d49a3a31aa6fbdde96dc3', '持明法州之 轮播图', '', 'images', NULL),
  ('13b708b6b12744ceb62b050cf6a3b78d', '持明法州之 日志管理', '', 'note', NULL),
  ('5a52ed6766e84ec9913b0e7fccbe3db9', '持明法州之 统计分析', '', 'chart_bar', NULL),
  ('418e2a4f87154e759a3c97faa83f6d2b', '持明法州之 上师', '', 'user_orange', NULL),
  ('2adcddd8c41d4b9aa8a0b7e40a19d083', '持明法州之 文章', '', 'layout', NULL),
  ('b2fea0ce80cc4b65ba250bf076c05c2f', '持明法州之 功课', '', 'outline', NULL),
  ('50af1d7d92f842a48c438105166cf4bc', '查询所有用户', '', 'group', '3d186b5934c04559ad9c8baf6d545777'),
  ('a017594be18543b8baaabf896141aee3', '1', '', 'flag_lu', '3d186b5934c04559ad9c8baf6d545777'),
  ('1f046464e6a544999323199082f0a536', '2', '', 'flag_mk', '7d89f292e71d49a3a31aa6fbdde96dc3'),
  ('2bde7bd57ecd4867953338fa20037d84', '3', '', 'flag_mu', '7d89f292e71d49a3a31aa6fbdde96dc3'),
  ('ac0a9a7a20a744278b0a0c9678f30d88', '4', '', 'flag_ms', '13b708b6b12744ceb62b050cf6a3b78d'),
  ('d5b89323acfd42339020cd01c841b8b7', '5', '', 'flag_ht', '13b708b6b12744ceb62b050cf6a3b78d'),
  ('15f0995ef0d64d74af514d955e5daadb', '6', '', 'flag_rw', '5a52ed6766e84ec9913b0e7fccbe3db9'),
  ('37bb4868d6f744d38c914118f5837c92', '7', '', 'flag_pk', '5a52ed6766e84ec9913b0e7fccbe3db9'),
  ('30f7f020f5154c1fbf8320184653082a', '8', '', 'flag_fk', '418e2a4f87154e759a3c97faa83f6d2b'),
  ('f5ae81ae240d4c29b7ecdd51464493af', '9', '', 'flag_br', '418e2a4f87154e759a3c97faa83f6d2b'),
  ('84babc971cbe4095ae11b31515123181', '10', '', 'flag_gd', '2adcddd8c41d4b9aa8a0b7e40a19d083'),
  ('f832691276374934909b44422cb464d0', '11', '', 'flag_ch', '2adcddd8c41d4b9aa8a0b7e40a19d083'),
  ('a9b1e72094314ff79795d8105a85165a', '12', '', 'flag_gf', 'b2fea0ce80cc4b65ba250bf076c05c2f'),
  ('168ecfdd8f894db69dad3e4d9fe2b05d', '13', '', 'flag_bv', 'b2fea0ce80cc4b65ba250bf076c05c2f');

SELECT
  F.id        id,
  F.text      text,
  F.icon      icon,
  F.url       url,
  S.id        sid,
  S.text      stext,
  S.url       surl,
  S.icon      sicon,
  S.father_id sfather
FROM t_menu F INNER JOIN t_menu S ON F.id = S.father_id;


SELECT
  A.id        aid,
  title,
  status,
  content,
  create_time createTime,
  update_time updateTime,
  L.id        lid,
  lama_name   lamaName
FROM cmfz.t_article A LEFT JOIN cmfz.t_lama L ON A.author_id = L.id;

