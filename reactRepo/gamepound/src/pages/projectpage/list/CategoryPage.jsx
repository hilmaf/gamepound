import React from 'react';
import styled from 'styled-components';
import ProjectBoxInfo from "../../../component/project/ProjectBoxInfo";

const StyledAllDiv = styled.div`
    width: 100%;
    .inner {
        width: 1200px;
        margin: 0 auto;
        & > div:first-child{
            & > div:first-child{
                display: flex;
                & > div{
                    border: 1px solid #c9c9c9;
                    border-radius: 5px;
                    width: fit-content;
                    height: fit-content;
                    padding: 5px;
                    margin-right: 5px;
                }
            }
            & > div:last-child{
                & > span{
                    color: var(--red-color);
                }
                margin-top: 20px;
                margin-bottom: 25px;
            }
            
        }
        & > div:last-child{
            display: grid;
            grid-template-columns: 1fr 1fr 1fr 1fr;
        }
    }
`;

const categoryPage = () => {
    return (
        <StyledAllDiv>
            <div className='inner'>
                <div>
                    <div>
                        <div>상태 ▽</div>
                        <div>달성률 ▽</div>
                    </div>
                    <div><span>20</span>개의 프로젝트가 있습니다.</div>
                </div>
                <div>
                    <ProjectBoxInfo no={1} project={1}/>
                    <ProjectBoxInfo no={1} project={1}/>
                    <ProjectBoxInfo no={1} project={1}/>
                    <ProjectBoxInfo no={1} project={1}/>
                    <ProjectBoxInfo no={1} project={1}/>
                </div>
            </div>
        </StyledAllDiv>
    );
};

export default categoryPage;