
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledNewCreateDiv = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    width: 450px;
    margin: 0 auto;
    & .continueBox {
        width: 100%;
        & ul {
            display: flex;
            flex-direction: column;
            gap: 10px;
            & li {
                display: flex;
                justify-content: space-between;
                align-items: center;
                background-color: #f5f5f5;
                border-radius: 5px;
                padding: 15px 20px;
                & .left {
                    display: flex;
                    align-items: center;
                    gap: 10px;
                    & span {
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        overflow: hidden;
                        width: 60px;
                        height: 60px;
                    }
                    & strong {
                        font-size: 15px;
                        font-weight: 500;
                        color: #333;
                    }
                }
                & button {
                    display: block;
                    padding: 10px 20px;
                    border: 1px solid #ddd;
                    border-radius: 30px;
                    color: #999;
                    cursor: pointer;
                    &:hover {
                        border-color: #333;
                        color: #333;
                    }
                }
            }
        }
        & .messege {
            display: flex;
            align-items: center;
            padding-bottom: 5px;
            font-size: 14px;
            font-weight: 400;
            color: #ED7474;
            &::before {
                content: "!";
                display: flex;
                align-items: center;
                justify-content: center;
                width: 17px;
                height: 17px;
                background-color: #ED7474;
                border-radius: 50%;
                font-size: 13px;
                color: #fff;
                margin-right: 5px;
            }
        }
    }
    & .categoryBox {
        margin-top: 50px;
        & h3 {
            margin-bottom: 20px;
            text-align: center;
            font-size: 20px;
            color: #333;
        }
        & dl {
            & dt {
                padding: 5px 0;
                font-size: 15px;
                color: #333;
            }
            & dd {
                & ul {
                    display: flex;
                    flex-wrap: wrap;
                    gap: 5px 10px;
                    & input {
                        position: absolute;
                        left: -9999em;
                    }
                    & label {
                        display: block;
                        font-size: 14px;
                        padding: 7px 20px;
                        border: 1px solid #ddd;
                        border-radius: 30px;
                        cursor: pointer;
                    }
                    & input:checked ~ label {
                        background-color: var(--red-color);
                        border: 1px solid transparent;
                        color: #fff;
                    }
                }
            }
        }
    }
    & > button {
        display: flex;
        background-color: var(--red-color);
        color: #fff;
        padding: 10px 20px;
        margin-top: 50px;
        border-radius: 5px;
        cursor: pointer;
    }
`;

const ProjectNewCreate = () => {

    const navigate = useNavigate();

    return (
        <StyledNewCreateDiv>
            <div className="continueBox">
                <div className="messege">작성중인 프로젝트가 있습니다!</div>
                <ul>
                    <li>
                        <div className="left">
                            <span><img src="" alt="프로젝트이미지" /></span>
                            <strong>프로젝트명</strong>
                        </div>
                        <button>이어서 작성</button>
                    </li>
                    <li>
                        <div className="left">
                            <span><img src="" alt="" /></span>
                            <strong>프로젝트명</strong>
                        </div>
                        <button>이어서 작성</button>
                    </li>
                </ul>
            </div>
            <div className="categoryBox">
                <h3>어떤 프로젝트를 계획 중 이신가요?</h3>
                <dl>
                    <dt>카테고리 선택</dt>
                    <dd>
                        <ul>
                            <li>
                                <input type="radio" id='rdo_1' name='category' value='카테고리no' />
                                <label htmlFor="rdo_1">카테고리명</label>
                            </li>
                            <li>
                                <input type="radio" id='rdo_2' name='category' value='카테고리no' />
                                <label htmlFor="rdo_2">카테고리명</label>
                            </li>
                            <li>
                                <input type="radio" id='rdo_3' name='category' value='카테고리no' />
                                <label htmlFor="rdo_3">카테고리명</label>
                            </li>
                            <li>
                                <input type="radio" id='rdo_4' name='category' value='카테고리no' />
                                <label htmlFor="rdo_4">카테고리명</label>
                            </li>
                            <li>
                                <input type="radio" id='rdo_5' name='category' value='카테고리no' />
                                <label htmlFor="rdo_5">카테고리명</label>
                            </li>
                        </ul>
                    </dd>
                </dl>
            </div>
            <button onClick={() => {
                navigate('/projectCreate/main/index');
            }}>시작하기</button>
        </StyledNewCreateDiv>
    );
};

export default ProjectNewCreate;